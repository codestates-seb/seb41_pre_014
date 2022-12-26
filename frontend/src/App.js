<<<<<<< HEAD
import { Provider } from "react-redux";
import { BrowserRouter } from "react-router-dom";
import styled from "styled-components";

import { Footer } from "./components/blocks/Footer";
import { Header } from "./components/blocks/Header";
import { Router } from "./router/Router";
import { store } from "./ducks/store";
import { LeftNavBar } from "./components/blocks/NavBar";

const StyledMain = styled.main`
  width: 100%;
  max-width: 126.4rem;
  margin: 0 auto;
  display:flex;
  justify-content: center;
`;

const StyledLeftSideBar = styled.div`
`;

const StyledMainContent = styled.div`
  width:100%;
  padding:2.4rem;
  height:100%;
  /* border-left: 1px solid #F1F2F3; */
`;

function App() {  
  return (
    <Provider store={store}>
      <BrowserRouter>
        <Header />
        <StyledMain>
          <StyledLeftSideBar>
            <LeftNavBar />
          </StyledLeftSideBar>
          <StyledMainContent>
            <Router />
          </StyledMainContent>
        </StyledMain>
        <Footer />
      </BrowserRouter>
    </Provider>
=======
import { SearchBar } from "./components/atoms/SearchBar";
import { UserMetaInfoType1, UserMetaInfoType3, UserMetaInfoType4 } from "./components/blocks/UserInfoContainer";
import { MainNavBar , MainLeftNavBar, MainLeftNavBar2 } from "./components/blocks/NavBar";
import { UserActivityAnswers } from "./components/blocks/UserActivityAnswers";
import { UserActivityQuestions } from "./components/blocks/UserActivityQuestions";
import { UserActivityTags } from "./components/blocks/UserActivityTags";
import { UserActivityVotes } from "./components/blocks/UserActivityVotes";
import { PostedQnA, UserStats } from "./components/blocks/UserProfile";
import { MainRight } from "./components/blocks/UserSettingsDeleteProfile";

function App() {
  return (
    <div>
      <SearchBar />
      <UserMetaInfoType3/>
      <UserMetaInfoType1/>
      <UserMetaInfoType4/>
      <MainNavBar/>
      <MainLeftNavBar/>
      <MainLeftNavBar2/>
      <UserActivityAnswers/>
      <UserActivityQuestions/>
      <UserActivityTags/>
      <UserActivityVotes/>
      <UserStats/>
      <PostedQnA/>
      <MainRight/>
    </div>
>>>>>>> upstream/dev
  );
}

export default App;
<<<<<<< HEAD



=======
>>>>>>> upstream/dev
