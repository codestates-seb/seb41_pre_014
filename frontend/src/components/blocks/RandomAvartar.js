import { useSelector } from 'react-redux';
import styled from 'styled-components';

export const RandomAvartar = (props) => {
  const loginUser =  useSelector(state => state.loginUserInfo?.loginUserInfo);
  const randomNum = Math.floor(Math.random() * colorList.length);

  return (
    <AvatarBg 
      width={props.width}
      height={props.height}
      backgroundColor={colorList[randomNum]} 
    >
      <AvatarTxt
        fontSize={props.fontSize}
      >
        {loginUser.email ? loginUser.email[0] : 'p'}
      </AvatarTxt>
    </AvatarBg>
  )
};

const colorList = [
  '#FF0000', '#DC143C', '#B22222', '#800000', '#8B0000',
  '#A52A2A', '#A0522D', '#8B4513', '#B8860B', '#808000',
  '#6B8E23', '#556B2F', '#228B22', '#006400', '#008080',
  '#008B8B', '#4682B4', '#4169E1', '#0000FF', '#0000CD',
  '#000080', '#00008B', '#191970', '#483D8B', '#6A5ACD',
  '#7B68EE', '#9370DB', '#9932CC', '#9400D3', '#8A2BE2',
  '#BA55D3', '#4B0082', '#8B008B', '#800080', '#C71585',
  '#FF1493', '#DB7093', '#778899', '#708090', '#808080',
  '#696969', '#2F4F4F',	'#000000',
];

const AvatarBg = styled.div`
  width: ${props => props.width || '12.8rem'};
  height: ${props => props.height || '12.8rem'};
  background-color: ${props => props.backgroundColor || 'black'};
  border-radius: 0.3rem;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const AvatarTxt = styled.div`
  font-size: ${props => props.fontSize || '6rem'};
  font-weight: 600;
  color: #FFF;
`;