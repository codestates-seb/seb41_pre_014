import styled from "styled-components";
import { useEffect } from 'react';
import { Button } from "../atoms/Button";

export const SNSShareBox = (props) => {
  const CopyLinkEventHandler = () => {
    doCopy(`localhost:3000/questions/${props.detailId}`);
  };

  useEffect(()=>{
    const script = document.createElement('script');
    script.src = 'https://developers.kakao.com/sdk/js/kakao.js';
    script.async = true;
    document.body.appendChild(script);
    return () => document.body.removeChild(script);
  },[])

  const ShareToKatalk = () => {
    if (window.Kakao) {
      const kakao = window.Kakao;

      if (!kakao.isInitialized()) {
        kakao.init(`${process.env.REACT_APP_KAKAO_JS_KEY}`);
      }

      kakao.Link.sendDefault({
        objectType: 'feed',
        content: {
          title: props.title,
          description: props.body,
          imageUrl: `/image/stackoverflowLogo.svg`,
          link: {}
        }
      })
    }
  }

  return (
    <StyledShareBoxWrapper>
      <ShareBoxLabel>
        <label htmlFor='sharebox'>Share a link to this question</label>&nbsp;
        <span>(Includes your user id)</span>
      </ShareBoxLabel>
      <ShareBoxInput>
        <input 
          id='sharebox'
          defaultValue={`localhost:3000/questions/${props.detailId}`}
          disabled
        ></input>
      </ShareBoxInput>
      <ShareBoxButtonWrapper>
        <Button 
          buttonName='Copy link'
          onClick={CopyLinkEventHandler}
          buttonType='type4'
          width='auto'
          height='auto'
          padding=' 0.6rem 1.2rem'
        />
        <Button 
          buttonName='CC BY-SA 4.0'
          onClick={() => window.open(
            'https://creativecommons.org/licenses/by-sa/4.0/',
            '_blank'
          )}
          buttonType='type4'
          width='auto'
          height='auto'
          padding=' 0.6rem 1.2rem'
        />
        <div>
          <ShareBoxButton>
            <img src='/image/facebookLogo.svg' alt='facebook' />
          </ShareBoxButton>
          <ShareBoxButton>
            <img src='/image/twitterLogo.svg' alt='twitter' />
          </ShareBoxButton>
          <ShareBoxButton onClick={ShareToKatalk}>
            <img src='/image/kakaoLogo.svg' alt='kakao' />
          </ShareBoxButton>
        </div>
      </ShareBoxButtonWrapper>
    </StyledShareBoxWrapper>
  )
};

// StyledShareBoxWrapper의 inset(top-right-bottom-left)를 통해서 위치를 조정해주세요!
const StyledShareBoxWrapper = styled.div`
  width: 34rem;
  position: absolute;
  top: 2rem;
  left: 0rem;
  background-color: #FFF;
  padding: 1.2rem;
  margin: 0;
  border: 0.1rem solid #D6D9DC;
  border-radius: 0.5rem;
  box-shadow: 6 0.1rem 0.3rem hsla(0,0%,0%,0.06), 
    0 0.2rem 0.6rem hsla(0, 0%, 0%, 0.06), 
    0 0.3rem 0.8rem hsla(0, 0%, 0%, 0.09);
  white-space: normal;
  z-index:999;

  & * {
    font-size: 1.3rem;
    color: #0c0d0e;
  }
`;

const ShareBoxLabel = styled.div`
  & > label {
    font-weight: bold;
  }
`;

const ShareBoxInput = styled.div`
  width: 100%;
  margin: 0.8rem 0;
  
  & > input {
    width: 100%;
    padding: 0.78rem 0.91rem;
    cursor: not-allowed;
  }
`;

const ShareBoxButtonWrapper = styled.div`
  display:flex;
  justify-content: space-between;
  align-items: center;

  & > div {
    display: flex;
  }
`;

const ShareBoxButton = styled.div`
  padding: 0.4rem;
  background-color: #FFF;
  display:flex;
  align-items: center;

  &:hover {
    background-color: #F0F8FF;
  }

  & > img {
      width: 2rem;
      border-radius: 0.5rem;
      cursor: pointer;
    }
`;


const doCopy = text => {
  // 흐름 1.
  if (navigator.clipboard) {
    // (IE는 사용 못하고, 크롬은 66버전 이상일때 사용 가능)
    navigator.clipboard
      .writeText(text)
      .then(() => {
        alert("클립보드에 복사되었습니다.");
      })
      .catch(() => {
        alert("복사를 다시 시도해주세요.");
      });
  } else {
    // 흐름 2.
    if (!document.queryCommandSupported("copy")) {
      return alert("복사하기가 지원되지 않는 브라우저입니다.");
    }

    // 흐름 3.
    const textarea = document.createElement("textarea");
    textarea.value = text;
    textarea.style.top = 0;
    textarea.style.left = 0;
    textarea.style.position = "fixed";

    // 흐름 4.
    document.body.appendChild(textarea);
    // focus() -> 사파리 브라우저 서포팅
    textarea.focus();
    // select() -> 사용자가 입력한 내용을 영역을 설정할 때 필요
    textarea.select();
    // 흐름 5.
    document.execCommand("copy");
    // 흐름 6.
    document.body.removeChild(textarea);
    alert("클립보드에 복사되었습니다.");
  }
};
