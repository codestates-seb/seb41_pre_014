import styled from 'styled-components';
import { Button } from '../components/atoms/Button';
import { Header } from '../components/blocks/Header';
import { Footer } from '../components/blocks/Footer';
import { LeftNavBar } from '../components/blocks/NavBar';
import { FilterButtonWrapper } from '../components/blocks/FilterButtonWrapper';
import { QuestionInfoContainer } from '../components/blocks/QuestionInfoContainer';
import { MainRightSideInfoWidget, MainRightTagBasic } from '../components/blocks/MainRight';
import { Page, PerPage } from '../components/blocks/Pagination'

const Body = styled.div`
  display: flex;
`;

const Main = styled.div`
  display: flex;
  padding: 2.4rem;
`;

const MainLeft = styled.div`
  display: flex;
  flex-direction: column;
  overflow: scroll;
`;

const MainTop = styled.div`
  display: flex;
  margin-bottom: 1.2rem;
  justify-content: space-between;
`;

const FilterContainer = styled.div`
  display: flex;
  margin-bottom: 1.2rem;
  align-items: flex-end;
`;

const Pagination = styled.div`
  display: flex;
  justify-content: space-between;
`;

const MainRight = styled.div`
  display: flex;
  flex-direction: column;
  gap: 1.6rem;
  padding-left: 2.4rem;
`;

export const QuestionBoard = () => {
  return (
    <>
      <Header />
      <Body>
        <LeftNavBar />
        <Main>
          <MainLeft>
            <MainTop>
              <h1>All Questions</h1>
              <Button buttonType='type2' />
            </MainTop>
            <FilterContainer>
              <FilterButtonWrapper />
            </FilterContainer>
            <ul>
              {/* <QuestionInfoContainer /> */}
            </ul>
            <Pagination>
              <Page />
              <PerPage />
            </Pagination>
          </MainLeft>
          <MainRight>
            <MainRightSideInfoWidget />
            <MainRightTagBasic />
          </MainRight>
        </Main>
      </Body>
      <Footer />
    </>
  )
};

export const HomeLoginBoard = () => {
  return (
    <>
      <Header />
      <Body>
        <LeftNavBar />
        <Main>
          <MainLeft>
            <MainTop>
              <h1>Top Questions</h1>
              <Button buttonType='type2' />
            </MainTop>
            <FilterContainer>
              <FilterButtonWrapper />
            </FilterContainer>
            <ul>
              {/* <QuestionInfoContainer /> */}
            </ul>
          </MainLeft>
          <MainRight>
            <MainRightSideInfoWidget />
            <MainRightTagBasic />
          </MainRight>
        </Main>
      </Body>
      <Footer />
    </>
  )
};