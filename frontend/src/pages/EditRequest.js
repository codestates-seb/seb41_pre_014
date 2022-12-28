import styled from 'styled-components';
import { NavItem } from '../components/atoms/NavItem';
import { Button } from '../components/atoms/Button';
import { TagBlock } from '../components/atoms/TagBlock';
import { LeftButtonWrapper } from '../components/blocks/DetailContainer';
import { QuestionHorizontalMetaInfoWrapper } from '../components/blocks/QuestionInfoContainer';
import { UserMetaInfoType1 } from '../components/blocks/UserInfoContainer';

const MainTop = styled.div`
  display: flex;
  flex-direction: column;
  gap: 0.8rem;
  border-bottom: 0.1rem solid hsl(210deg 8% 90%);
  padding-bottom: 1.6rem;

  > h1 {
      color: #3b4045;
      font-size: 2.7rem;
      overflow-wrap: break-word;
      margin-bottom: 0.8rem;
      display: block;
      text-align: left;
    }

    & .NavItemWrapper {
      display: flex;
      list-style: none;
      gap: 0.2rem;
      justify-content: flex-end;
    }
`;

const MainLeftRight = styled.div`
  display: flex;
  gap: 1.6rem;
`;

const MainLeft = styled.div`
  display: flex;
  flex-direction: column;

  > h2 {
    font-size: 2.1rem;
    padding: 1.6rem 0;
  }

  > h3 {
    padding: 0.8rem 0;

    > a {
        font-size: 1.7rem;
        color: hsl(206deg 100% 40%);
        overflow-wrap: break-word;
        text-decoration: none;
      }
  }
  
`;

const EditInfo = styled.div`
  display: flex;
  margin-top: 0.8rem;

  .originalProposed {
    display: flex;
    gap: 1.6rem;
    
    > div {
      font-size: 1.5rem;
    }
  }

  .editorInfo {
    display: flex;
    gap: 0.4rem;

    > div {
      font-size: 1.5rem;
    }
  }
`;

const MainRight = styled.div`

`;

const TagContainer = styled.div`
  display: flex;
  flex-direction: column;
  position: relative;
  margin: 1.6rem 0;
  background-color: #ffffff;
  border-radius: 0.3rem;
  box-shadow: 0 0.1rem 0.2rem hsla(0,0%,0%,0.05), 0 0.1rem 0.4rem hsla(0, 0%, 0%, 0.05), 0 0.2rem 0.8rem hsla(0, 0%, 0%, 0.05);
  width: 29.8rem;
  font-size: 1.3rem;
`;

const TagHeader = styled.div`
  display: flex;
  background-color: #f8f9f9;
  border-top: 0.1rem solid #e3e6e8;
  border-top-left-radius: 0.3rem;
  border-top-right-radius: 0.3rem;
  font-size: 1.5rem;
  color: #232629;
  padding: 1.2rem 1.5rem;
`;

const TagContent = styled.div`
  display: flex;
  flex-direction: column;
  border-top: 0.1rem solid #e3e6e8;
  font-size: inherit;
  padding: 1.6rem;
  align-items: center;
`;

const TagFooter = styled.div`
  display: flex;
  gap: 0.6rem;
  border-top: 0.1rem solid #e3e6e8;
  padding: 1.2rem 1.5rem;
`;

const EditRequest = (props) => {
  return (
    <>
      <MainTop>
        <h1>Suggested edits</h1>
        <div className='NavItemWrapper'>
          <NavItem 
            NavItemType='type1'
            NavItemName='Review tasks'
            width='9.6rem'
            height='2.9rem'
          />
          <NavItem 
            NavItemType='type3'
            NavItemName='Stats'
            width='5.4rem'
            height='2.9rem'
          />
          <NavItem 
            NavItemType='type3'
            NavItemName='History'
            width='6.5rem'
            height='2.9rem'
          />
        </div>
      </MainTop>
      <MainLeftRight>
        <MainLeft>
          <h2>Review the following question edit</h2>
          <QuestionHorizontalMetaInfoWrapper />
          <h3><a href={props.link}>{props.title}title</a></h3>
          <UserMetaInfoType1 className='userMetaInfo' />
          <EditInfo>
            <LeftButtonWrapper />
            <div className='editInfoWrapper'>
              <div className='originalProposed'>
                <div>original{props.original}</div>
                <div>proposed{props.proposed}</div>
              </div>
              {/* <div><TagBlock /></div> */}
              <div className='editorInfo'>
                <div>Proposed</div>
                <div>{props.time}time</div>
                <div><img alt={props.username} src={props.avatarUrl} />avatar</div>
                <div>{props.username}username</div>
              </div>
            </div>
          </EditInfo>
        </MainLeft>
        <MainRight>
          <TagContainer>
            <TagHeader>Actions</TagHeader>
            <TagContent>
            <Button buttonType='type3' buttonName='Approve' />
            <Button buttonType='type3' buttonName='Reject' />
            </TagContent>
            <TagFooter>
              <Button   
                  buttonType='type2'buttonName='Submit'
                  width='6.6rem' />
              <Button 
                buttonType='type4' buttonName='Skip'
                width='5.2rem' />
            </TagFooter>
          </TagContainer>
        </MainRight>
      </MainLeftRight>
    </>
  )
};

export default EditRequest;