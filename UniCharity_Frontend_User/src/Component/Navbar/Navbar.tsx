import React from 'react'
import { useNavigate } from 'react-router-dom'
import { useAuth } from '../../Context/UseAuth'
import DefaultUser from '/images/avatar/DefaultUser.png'

const Navbar = () => {
    const navigate = useNavigate()
    const { isLoggedIn, user } = useAuth()
    return (
        <div className="navbar navbar-expand-lg bg-light shadow-lg">
            <div className="container">
                <a className="navbar-brand" href="index.html">
                    <img src="/images/logo.png" className="logo img-fluid" alt="Kind Heart Charity" />
                    <span>
                        Đại Học Sài Gòn Charity
                        <small>Non-profit Organization</small>
                    </span>
                </a>

                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>

                <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav ms-auto">
                        <li className="nav-item">
                            <a className="nav-link click-scroll"
                                style={{ cursor: "pointer" }}
                                onClick={() => navigate("/")}
                            >Home</a>
                        </li>

                        <li className="nav-item">
                            <a className="nav-link click-scroll"
                                style={{ cursor: "pointer" }}
                                onClick={() => navigate("/request-campaign")}
                            >Request Campaign</a>
                        </li>

                        <li className="nav-item">
                            <a className="nav-link click-scroll" href="#section_6">History donation</a>
                        </li>
                        {isLoggedIn() ? (
                            <div className="btn-group">
                                <button
                                    type="button"
                                    className="btn btn-sm btn-light dropdown-toggle"
                                    data-bs-toggle="dropdown"
                                    aria-expanded="false"
                                >
                                    {user?.name || "Dropdown"}
                                </button>
                                <ul className="dropdown-menu dropdown-menu-end">
                                    <li>
                                        <button className="dropdown-item" type="button">
                                            Profile
                                        </button>
                                    </li>
                                    <li>
                                        <button className="dropdown-item" type="button">
                                            Log out
                                        </button>
                                    </li>
                                </ul>

                                <div className="btn-group mx-2 btn-group mx-2 d-flex align-items-center">
                                    <img src={DefaultUser} style={{ height: "36px", width: "36px" }} alt="" />
                                </div>
                            </div>


                        ) : <>
                            <li className="nav-item ms-3"
                                onClick={() => navigate("/login")}
                            >
                                <a className="nav-link custom-btn custom-border-btn btn">Login</a>
                            </li>

                            <li className="nav-item ms-3">
                                <a className="nav-link custom-btn custom-border-btn btn">Register</a>
                            </li>
                        </>}
                    </ul>
                </div>
            </div>
        </div>
    )
}

export default Navbar
