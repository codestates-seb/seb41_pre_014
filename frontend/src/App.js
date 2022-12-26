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
  );
}

export default App;



