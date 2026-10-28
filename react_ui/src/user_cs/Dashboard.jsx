import { NavBar } from "../components/NavBar"
import SideBar from "./SideBar"
import UsersList from "./UsersList"

function UserDashboard() {

    return (
        <div className="container-flex">
            <div className="row">
                <div className="col-lg-2">
                    <SideBar />
                </div>
                <div className="col-md-10">
                    <div className="row">
                        <UsersList/>
                    </div>
                </div>
            </div>


        </div>
    )
}
export default UserDashboard