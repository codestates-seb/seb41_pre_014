import styled from "styled-components";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faTriangleExclamation } from '@fortawesome/free-solid-svg-icons';
import { Link } from 'react-router-dom'

const NotFountContainer = styled.div`
  width: 100%;
  height:100%;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const NotFoundLeft = styled.div`
  font-size: 24rem;
  margin-right: 5rem;
  color: #7d7d7d;
`;

const NotFoundRight = styled.div``;

const NotFoundTitle = styled.h1`
  font-size: 2.7rem;
  color: #232629;
  margin-bottom: 0.4rem;
`;

const NotFoundSubTitle = styled.div`
  margin-bottom: 2.4rem;
  font-size: 1.9rem;
  color: #232629;
`;

const NotFoundCont = styled.div`
  & > p {
    font-size: 1.5rem;
    color: #232629;
    margin-bottom: 1.5rem;

    & > a {
      font-size: 1.5rem;
      color: #0074CC;
    }
  }
`;


const NotFound = () => {
  return (
    <NotFountContainer>
      <NotFoundLeft>
        <FontAwesomeIcon icon={faTriangleExclamation} />
      </NotFoundLeft>
      <NotFoundRight>
        <NotFoundTitle>Page Not Found</NotFoundTitle>
        <NotFoundSubTitle>
          We're sorry, we couldn't find the page you requested.
        </NotFoundSubTitle>
        <NotFoundCont>
          <p>Try&nbsp;
            <a
              href='https://stackoverflow.com/nocaptcha?s=4c8d9879-7283-40d6-807c-4e766dffc500'
              target='_blank'
              rel='noreferrer'
            >searching for similar questions</a>
          </p>
          <p>Browse our&nbsp;
            <Link to='/questions'>recent questions</Link>
          </p>
          <p>Browse our popular tags</p>
          <p>If you feel something is missing that should be here,&nbsp;
            <a
              href='https://stackoverflow.com/contact'
              target='_blank'
              rel='noreferrer'
            >contact us.</a>
          </p>
        </NotFoundCont>
      </NotFoundRight>
    </NotFountContainer>
  )
};

export default NotFound;