import { Route, Routes } from "react-router"
import CoursesList from "./components/CoursesList"
import UserDashboard from "./user_cs/Dashboard"
import PostDashboard from "./components/posts/PostDashboard"
import { NavBar } from "./components/NavBar"


const App = () => {
  return (
    <div className="container-flex">
      <div className="row">
        <div className="col-lg-12">
          <NavBar />
        </div>

      </div>
      <div className="row mt-4">
        <div className="col-lg-12">
          <div>
            <Routes>
              <Route path="" element={<CoursesList />}></Route>
              <Route path="users" element={<UserDashboard />}></Route>
              <Route path="posts" element={<PostDashboard />}></Route>
            </Routes>
          </div>
        </div>

      </div>

    </div>

  )
}

export default App