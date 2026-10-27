import { AddTicket } from "./components/AddTicket"
import { Auth } from "./components/Auth"
import CoursesList from "./components/CoursesList"
import { NavBar } from "./components/NavBar"
import Nums from "./components/Nums"
import { Todo } from "./components/Todo"


const App = () => {
  return (
    <div>
      <div className="row">
        <div className="col-md-11">
          <NavBar />
        </div>
        <div className="col-md-1">
          <Auth />
        </div>
      </div>
      <div className="row">
        <div className="col-md-4">
          <Nums />
        </div>
        <div className="col-md-8">
          {/* <Todo /> */}
          &nbsp;
          <CoursesList/>
        </div>
      </div>
      <div className="row">
        <div className="col-md-4">
          <AddTicket/>

        </div>
      </div>
      <div className="row">

      </div>

    </div>
  )
}

export default App