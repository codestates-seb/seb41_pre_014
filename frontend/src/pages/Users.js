import { MainNavBar } from "../components/blocks/NavBar";
import { UserMetaInfoType3 } from "../components/blocks/UserInfoContainer";
import { UserEditForm, UserSettingsEditProfile } from "../components/blocks/UserSettingsEditProfile";


const Users = () => {
  return (
    <div>
      <UserMetaInfoType3/>
      {/*edit profile 버튼*/}
      <MainNavBar/>
    </div>
  )
};

export default Users;