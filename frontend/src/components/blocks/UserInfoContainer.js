import styled from 'styled-components';

const StyledDiv1 = styled.div`
  height: 3.6rem;
  display: flex;
  font-size: 1.3rem;
  gap: 0.4rem;
  align-items: center;
  & > div > a {
    display: flex;
    align-items: center;
  }
  & > .username-score {
    gap: 0.4rem;
    display: flex;
    & > div > .score {
      font-weight: bold;
    }
  }
  & > span {
    color: #6a737c
  }
`

const StyledImg = styled.img`
  width: 2rem;
  height: 2rem;
  border-radius: 0.3rem;
`

const StyledA = styled.a`
  text-decoration: none;
  color: hsl(206,100%,40%);
  &:hover {
    color: hsl(206,100%,52%);
  }
`

// 작성한 질문 갯수 -> reputation score
export const UserMetaInfoType1 = () => {
  return (
    <StyledDiv1>
      <div>
        <a href=''>
          <StyledImg alt='mini user avatar' src='https://www.gravatar.com/avatar/0555bd0deb416a320a0069abef08078a?s=128&d=identicon&r=PG&f=1'></StyledImg>
        </a>
      </div>
      <div className='username-score'>
        <div>
          <StyledA href='' className='username'>username</StyledA>
        </div>
        <div>
          <span className='score'>11</span>
        </div>
      </div>
      <span>asked 1 min ago</span>
    </StyledDiv1>
  )
} 

const StyledDiv3 = styled.div`
  width: 80.4rem;
  height: 21rem;
  display: flex;
  
  &>a{
    display: flex;
    flex-direction: column;
    justify-content: center;
    margin: 0.8rem;
    >.avatarWrap>.avatarPic {
    width: 17.8rem;
    height: 17.8rem;
    border-radius: 0.5rem;
    box-shadow: 0rem 0.2rem 0.2rem 0.2rem #e3e6e8;
  }
  }
  
  
    
  & >.infoWrap {
    display: flex;
    justify-content: center;
    flex-direction: column;
    flex-grow: 1;
    &>.username {
      margin: 0.4rem 0.4rem 1.2rem;
      font-size: 3rem;
      font-weight: bold;
    }
    &>.userTitle {
      margin: 0 0.4rem 0.9rem;
      font-size: 2.1rem;
      font-weight: bold;
      color: #6A737C;
    }
    &>ul {
      display: flex;
      list-style: none;
      padding-left: 0rem;
      margin: 0;
      &>li {
        /* margin: 0.2rem; */
        display: flex;
        font-size: 1.3rem;
        color: #6A737C;
        align-items: center;
        margin-left: 0.2rem;
        &>div {
          display: flex;
          align-items: center;
          margin-left: 0.2rem;
        }
        &>button {
          all: unset;
          display: flex;
          align-items: center;
          &>div {
            margin-left: 0.2rem;
            display: flex;
            align-items: center;
          }
        }
      }
    }
  }
`

// a 안에 href='' => useParams? useLocation?
// 폰트 적용 필요 font-family: -apple-system,BlinkMacSystemFont,"Segoe UI Adjusted","Segoe UI","Liberation Sans",sans-serif;
export const UserMetaInfoType3 = () => {
  return (
    <StyledDiv3>
      <a href=''> 
        <div className='avatarWrap'>
          <img className='avatarPic' alt='user avatar' src='https://www.gravatar.com/avatar/0555bd0deb416a320a0069abef08078a?s=128&d=identicon&r=PG&f=1'></img>
        </div>
      </a>
      <div className='infoWrap'>
        <div className='username'>mklement0</div>
        <div className='userTitle'>Full Stack Developer</div>
        <ul>
          <li>
            <div>
            <svg xmlns="http://www.w3.org/2000/svg" width="1.8rem" height="1.8rem" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><path fill="#9199a1" d="M12.68 5.88c.7-.24 1.22-.9 1.3-1.64c.05-.47-.05-.91-.28-1.27L12.42.75a.506.506 0 0 0-.87 0l-1.28 2.22c-.17.3-.27.65-.27 1.03c0 1.32 1.3 2.35 2.68 1.88zm3.85 10.04l-1-1l-1.08 1.07c-1.3 1.3-3.58 1.31-4.89 0l-1.07-1.07l-1.09 1.07C6.75 16.64 5.88 17 4.96 17c-.73 0-1.4-.23-1.96-.61V20c0 1.1.9 2 2 2h14c1.1 0 2-.9 2-2v-3.61c-.75.51-1.71.75-2.74.52c-.66-.14-1.25-.51-1.73-.99zM18 9h-5V8c0-.55-.45-1-1-1s-1 .45-1 1v1H6c-1.66 0-3 1.34-3 3v1.46c0 .85.5 1.67 1.31 1.94c.73.24 1.52.06 2.03-.46l2.14-2.13l2.13 2.13c.76.76 2.01.76 2.77 0l2.14-2.13l2.13 2.13c.43.43 1.03.63 1.65.55c.99-.13 1.69-1.06 1.69-2.06v-1.42A2.983 2.983 0 0 0 18 9z"/></svg>
            </div>
            <div>Member for 14 years</div>
          </li>
          <li>
            <div>
            <svg xmlns="http://www.w3.org/2000/svg" width="1.8rem" height="1.8rem" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><path fill="#9199a1" d="M12 20a8 8 0 0 0 8-8a8 8 0 0 0-8-8a8 8 0 0 0-8 8a8 8 0 0 0 8 8m0-18a10 10 0 0 1 10 10a10 10 0 0 1-10 10C6.47 22 2 17.5 2 12A10 10 0 0 1 12 2m.5 5v5.25l4.5 2.67l-.75 1.23L11 13V7h1.5Z"/></svg>
            </div>
            <div>Last seen this week</div>
          </li>
          <li>
            <button>
              <div>
              <svg xmlns="http://www.w3.org/2000/svg" width="1.8rem" height="1.8rem" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><path fill="#9199a1" d="M12 14q-.425 0-.712-.288Q11 13.425 11 13t.288-.713Q11.575 12 12 12t.713.287Q13 12.575 13 13t-.287.712Q12.425 14 12 14Zm-4 0q-.425 0-.713-.288Q7 13.425 7 13t.287-.713Q7.575 12 8 12t.713.287Q9 12.575 9 13t-.287.712Q8.425 14 8 14Zm8 0q-.425 0-.712-.288Q15 13.425 15 13t.288-.713Q15.575 12 16 12t.712.287Q17 12.575 17 13t-.288.712Q16.425 14 16 14Zm-4 4q-.425 0-.712-.288Q11 17.425 11 17t.288-.712Q11.575 16 12 16t.713.288Q13 16.575 13 17t-.287.712Q12.425 18 12 18Zm-4 0q-.425 0-.713-.288Q7 17.425 7 17t.287-.712Q7.575 16 8 16t.713.288Q9 16.575 9 17t-.287.712Q8.425 18 8 18Zm8 0q-.425 0-.712-.288Q15 17.425 15 17t.288-.712Q15.575 16 16 16t.712.288Q17 16.575 17 17t-.288.712Q16.425 18 16 18ZM5 22q-.825 0-1.413-.587Q3 20.825 3 20V6q0-.825.587-1.412Q4.175 4 5 4h1V2h2v2h8V2h2v2h1q.825 0 1.413.588Q21 5.175 21 6v14q0 .825-.587 1.413Q19.825 22 19 22Zm0-2h14V10H5v10Z"/></svg>
              </div>
              <div>visited 4 days, 1 consecutive</div>
            </button>
          </li>
        </ul>
        <ul>
          <li>
            <div>
            <svg xmlns="http://www.w3.org/2000/svg" width="1.8rem" height="1.8rem" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><path fill="#9199a1" d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5a2.5 2.5 0 0 1 0-5a2.5 2.5 0 0 1 0 5z"/></svg>
            </div>
            <div>Seoul</div>
          </li>
        </ul>
      </div>
    </StyledDiv3>
  )
}

export const StyledAvatar = styled.img`
  width: 4.8rem;
  border-radius: 0.3rem;
`

export const StyledUsername = styled(StyledA)`
  font-size: 1.5rem;
`

export const StyledDiv4 = styled.div`
  display: flex;
  width: 27.9rem;
  height: 8.2rem;

  & > div {
    display: flex;
    flex-direction: column;
    margin-left: 0.9rem;
  }
`

export const UserMetaInfoType4 = () => {
  return (
    <div>
      <StyledDiv4>
        <a href="">
          <StyledAvatar
            alt="user avatar"
            src="https://www.gravatar.com/avatar/0555bd0deb416a320a0069abef08078a?s=128&d=identicon&r=PG&f=1"
          ></StyledAvatar>
        </a>
        <div>
          <StyledUsername className="user-name">VonC</StyledUsername>
          <span className="user-location">France</span>
          <StyledA>javascript</StyledA>
        </div>
      </StyledDiv4>
    </div>
  );
}