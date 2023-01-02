import { UserDetailMainTop } from "../components/blocks/UserDetailMainTop";
import { Outlet } from "react-router-dom";

const UserDetail = () => {
  
  return (
    <div>
      <UserDetailMainTop />
      <Outlet />
    </div>
  )
}

export default UserDetail;