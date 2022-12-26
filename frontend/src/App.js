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
  );
}

export default App;
