import styled from "styled-components"

const UserAndTimeInfo = styled.div`
  display: flex;
  gap: 0.3rem;
  align-items: flex-end;
`;

// UserMetaInfoType1: avatar, username, 질문개수, 시간
export const UserMetaInfoType1 = () => {
  return (
    <UserAndTimeInfo>
      <div><img /></div>
      <div>HJA24</div>
      <div>747</div>
      <div>asked Dec 12 at 13:55</div> 
    </UserAndTimeInfo>
  )
};