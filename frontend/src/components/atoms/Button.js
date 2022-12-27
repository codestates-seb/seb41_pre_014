import styled from 'styled-components';

const StyledButton = styled.button`
  cursor: pointer;
  margin: ${props => props.margin || '0'};
  padding: ${props => props.padding || '0'};
  width: ${props => props.width || '15rem'};
  height: ${props => props.height || '4rem'};
  font-size: ${props => props.fontSize || '1.3rem'};
  font-weight: ${props => props.fontWeight || 'normal'};
  border-radius: ${props => props.borderRadius || '0.3rem'};
  box-shadow: ${props => props.boxShadow || 'none'};

  &.type1 {
    background-color: #F2740D;
    color: #FFF;
    border: 0.1rem solid #F2740D;

    &:hover {
      background-color: #DA680B;
    }
  };

  &.type2 {
    background-color: #0A95FF;
    color: #FFF;
    border: 0.1rem solid #0A95FF;
    box-shadow: ${props => props.boxShadow ||
      'inset 0 0.1rem 0 0 hsla(0,0%,100%,0.4)'};

    &:hover {
      background-color: #0074CC;
    }
  };

  &.type3 {
    background-color: #E1ECF4;
    color: #39739D;
    border: 0.1rem solid #39739D;

    &:hover {
      background-color: #B3D3EA;
      color: #2C5877;
    }
  };

  &.type4 {
    background-color: #FFF;
    color: #0074CC;
    border: 0.1rem solid #FFF;

    &:hover {
      background-color: #F0F8FF;
      color: #0063BF;
    }
  };
`;

// < Button Type >
// type1 - 주황색 배경
// type2 - 파란색 배경
// type3 - 하늘색 배경
// type4 - 하얀색 배경
export const Button = (props) => {
  return (
      <StyledButton 
        className={props.buttonType}
        type={props.buttonFunctionType}
        width={props.width}
        height={props.height}
        padding={props.padding}
        margin={props.margin}
        fontSize={props.fontSize}
        fontWeight={props.fontWeight}
        borderRadius={props.borderRadius}
        boxShadow={props.boxShadow}
        onClick={props.onClick}
      >{props.buttonName}</StyledButton>
  )
};


const StyledSNSButton = styled.button`
  cursor: pointer;
  width: 100%;
  height:100%;
  border-radius: 0.5rem;
  display: flex;
  justify-content: center;
  align-items: center;
  margin: ${props => props.margin || '0'};
  padding: ${props => props.padding || '0'};

  &.google {
    background-color: #fff;
    color: #3b4045;
    border: 0.1rem solid #D6D9DC;

    & > span {
      width: 1.8rem; 
      height: 1.8rem;
      background: url('/image/snsLogoSprites.png') -0.18rem -2.34rem;
      background-size: 4.32rem;
      display: flex;
      margin-right: 0.5rem;
    }
  };

  &.github {
    background-color: #2f3337;
    color: #fff;
    border: 0.1rem solid #D6D9DC;

    & > span {
      width: 1.8rem; 
      height: 1.8rem;
      background: url('/image/snsLogoSprites.png') -2.34rem -0.18rem;
      background-size: 4.32rem;
      display: flex;
      margin-right: 0.5rem;
    }
  };

  &.facebook {
    background-color: #385499;
    color: #fff;
    border: 0.1rem solid transparent;

    & > span {
      width: 1.8rem; 
      height: 1.8rem;
      background: url('/image/snsLogoSprites.png') -0.18rem -0.18rem;
      background-size: 4.32rem;
      display: flex;
      margin-right: 0.5rem;
    }
  };
`;


export const SNSLoginButton = (props) => {
  return (
    <StyledSNSButton 
      className={props.buttonType}
      padding={props.padding}
      margin={props.margin}
    >
      <span></span>
      {props.buttonName}
    </StyledSNSButton>
  )
};