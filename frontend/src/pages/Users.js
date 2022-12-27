import { MainNavBar } from "../components/blocks/NavBar";
import { UserMetaInfoType3 } from "../components/blocks/UserInfoContainer";
import { UserEditForm, UserSettingsEditProfile } from "../components/blocks/UserSettingsEditProfile";
import { Outlet } from 'react-router-dom';

const Users = () => {
  return (
    <div>
      <UserMetaInfoType3/>
      {/*edit profile 버튼*/}
      <MainNavBar/>
      <Outlet />
    </div>
  )
};

export default Users;