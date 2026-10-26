import { Auth } from "./components/Auth"
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
          <Auth/>
        </div>
      </div>
      <div className="row">
        <div className="col-md-4">
            <Nums/>
        </div>
        <div className="col-md-8">
          <Todo/>
        </div>
      </div>
      <div className="row">

      </div>
      <div className="row">

      </div>

    </div>
  )
}

export default App