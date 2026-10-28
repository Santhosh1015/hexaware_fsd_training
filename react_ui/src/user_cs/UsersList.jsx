import { useState } from "react"
import { Users } from "../data/Users"


function UsersList() {

    const [users, setUsers] = useState([...Users])
    const [id,setId] = useState("")
    const [name, setName] = useState("")
    const [username, setUserName] = useState("")
    const [city, setCity] = useState("")
    const [website, setWebsite] = useState("")
    const [companyName, setCompanyName] = useState("")

    const [onAdd , setOnAdd] = useState(false)

    const onDelete = (courseId) => {
        setUsers([...users.filter(u => u.id !== courseId)])
    }

    const onEdit = (user) => {
        setId(user.id)
        setName(user.name)
        setUserName(user.username)
        setCity(user.address.city)
        setWebsite(user.website)
        setCompanyName(user.company.name)

        setOnAdd(false)

    }

    const addUser = () => {
        let userObj = {
            name: name,
            username: username,
            address: {
                city: city
            },
            website: website,
            company: {
                name: companyName
            }

        }

        setUsers([userObj, ...users])
    }

    const editUser = () => {
        let userObj = {
            name: name,
            username: username,
            address: {
                city: city
            },
            website: website,
            company: {
                name: companyName
            }

        }

        let temp = [...users]

        temp = temp.filter((u)=>u.id !== id)

        setUsers([userObj,...temp])

    }
    return (
        <div className="card">
            &nbsp;
            <div className="card-header d-flex justify-content-between">
                <h4>User Details</h4>
                <button className="btn btn-outline-dark"
                    onClick={() => {
                        setName("")
                        setUserName("")
                        setCity("")
                        setWebsite("")
                        setCompanyName("")
                        setOnAdd(true)
                    }}
                    data-bs-toggle="modal"
                    data-bs-target="#userModal"> Add User</button>
            </div>
            <div className="card-body">
                <div className="table-responsive">

                    <table className="table table-striped">
                        <thead className="table-info">
                            <tr>
                                <th scope="col">S.No.</th>
                                <th scope="col">Name</th>
                                <th scope="col">username</th>
                                <th scope="col">City</th>
                                <th scope="col">Website</th>
                                <th scope="col">CompanyName</th>
                                <th scope="col"></th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                users.map((u, index) => (
                                    <tr key={index}>
                                        <th >{index + 1}</th>
                                        <td>{u.name}</td>
                                        <td>{u.username}</td>
                                        <td>{u.address.city}</td>
                                        <td>{u.website}</td>
                                        <td>{u.company.name}</td>
                                        <td>
                                            <a href="Javascript.void(0)" onClick={(e) => { e.preventDefault() }} style={{ textDecoration: 'none', color: 'inherit' }}>
                                                <i className="bi bi-trash3" onClick={() => onDelete(u.id)}></i>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="Javascript.void(0)" onClick={(e) => { e.preventDefault() }} style={{ textDecoration: 'none', color: 'inherit' }}>
                                                <i className="bi bi-pencil-square" onClick={() => onEdit(u)} data-bs-toggle="modal" data-bs-target="#userModal"></i>
                                            </a>
                                        </td>
                                    </tr>
                                ))
                            }

                        </tbody>
                    </table>

                </div>
            </div>

            <div className="modal fade" id="userModal" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-header">
                            {
                                onAdd?
                                <h5 className="modal-title" id="exampleModalLabel">Add User</h5>
                                :
                                <h5 className="modal-title" id="exampleModalLabel">Edit User</h5>
                            }
                            
                            <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div className="modal-body">
                            <div>
                                <label>Name</label>
                                <input type="text" value={name} onChange={(e) => setName(e.target.value)} className="form-control" required="required" />
                            </div>
                            <div>
                                <label>username</label>
                                <input type="text" value={username} onChange={(e) => setUserName(e.target.value)} className="form-control" required="required" />
                            </div>
                            <div>
                                <label>City</label>
                                <input type="text" value={city} onChange={(e) => setCity(e.target.value)} className="form-control" required="required" />
                            </div>
                            <div>
                                <label>Website</label>
                                <input type="text" value={website} onChange={(e) => setWebsite(e.target.value)} className="form-control" required="required" />
                            </div>
                            <div>
                                <label>CompanyName</label>
                                <input type="text" value={companyName} onChange={(e) => setCompanyName(e.target.value)} className="form-control" required="required" />
                            </div>
                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            {
                                onAdd?
                                <button type="button" className="btn btn-primary" onClick={() => addUser()} data-bs-dismiss="modal" >Add</button>
                                :
                                <button type="button" className="btn btn-primary" onClick={() => editUser()} data-bs-dismiss="modal" >Edit</button>
                            }
                            
                            
                        </div>
                    </div>
                </div>
            </div>
        </div >


    )
}
export default UsersList