function SideBar() {
    return (
        <div className="row">

            {/* Sidebar */}
            <nav className="bg-dark min-vh-100 text-white p-3">
                <h3>Menu</h3>

                <ul className="nav flex-column">
                    <li className="nav-item">
                        <h5><a className="nav-link text-white" href="#">
                            Dashboard
                        </a></h5>
                    </li>

                     <li className="nav-item">
                        <h5><a className="nav-link text-white" href="#">
                            Dashboard
                        </a></h5>
                    </li>
                     <li className="nav-item">
                        <h5><a className="nav-link text-white" href="#">
                            Dashboard
                        </a></h5>
                    </li>
                </ul>
            </nav>
        </div>
    )
}
export default SideBar