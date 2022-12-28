import { Provider } from "react-redux";
import { BrowserRouter } from "react-router-dom";
import styled from "styled-components";

import { Footer } from "./components/blocks/Footer";
import { Header } from "./components/blocks/Header";
import { Router } from "./router/Router";
import { store } from "./ducks/store";
import { LeftNavBar } from "./components/blocks/NavBar";

const StyledMain = styled.main`
  min-height: 100%; 
  min-width: 126.4rem;
  max-width: 126.4rem;
  margin: 0 auto;
  display:flex;
  justify-content: center;
`;

const StyledMainContent = styled.div`
  width:100%;
  min-height:inherit;
  padding:2.4rem;
  display:flex;
  flex-direction: column;
  justify-content: start;
`;

function App() {  
  return (
    <Provider store={store}>
      <BrowserRouter>
        <Header />
        <StyledMain>
          <LeftNavBar />
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