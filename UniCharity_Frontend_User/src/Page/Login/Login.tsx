import React from 'react'

const Login = () => {
    return (

        <section className="volunteer-section section-padding" id="section_4">
            <div className="container">
                <div className="row">

                    <div className="col-lg-6 col-12">
                        <h2 className="text-white mb-4"></h2>

                        <form className="custom-form volunteer-form mb-5 mb-lg-0" action="#" method="post" role="form">
                            <div className="col-lg-6 col-12">
                                <form className="custom-form login-form mb-5" action="#" method="post" role="form">
                                    <h3 className="mb-4">ĐĂNG NHẬP</h3>

                                    <div className="mb-3">
                                        <input
                                            type="email"
                                            name="email"
                                            id="email"
                                            pattern="[^ @]*@[^ @]*"
                                            className="form-control"
                                            placeholder="Jackdoe@gmail.com"
                                            required
                                        />
                                    </div>

                                    <div className="mb-3">
                                        <input
                                            type="password"
                                            name="password"
                                            id="password"
                                            className="form-control"
                                            placeholder="Mật khẩu"
                                            required
                                        />
                                    </div>

                                    <button type="submit" className="form-control btn btn-primary">Đăng nhập</button>
                                </form>
                            </div>
                        </form>
                    </div>

                    <div className="col-lg-6 col-12">
                        <img src="images/smiling-casual-woman-dressed-volunteer-t-shirt-with-badge.jpg"
                            className="volunteer-image img-fluid" alt="" />

                        <div className="custom-block-body text-center">
                            <h4 className="text-white mt-lg-3 mb-lg-3">About Volunteering</h4>

                            <p className="text-white">Lorem Ipsum dolor sit amet, consectetur adipsicing kengan omeg kohm
                                tokito Professional charity theme based</p>
                        </div>
                    </div>

                </div>
            </div>
        </section>
    )
}

export default Login
