import React from 'react'
import { useForm } from 'react-hook-form'
import * as yup from 'yup'
import { yupResolver } from '@hookform/resolvers/yup'
import { useAuth } from '../../Context/UseAuth'

type LoginFormInput = {
    email: string
    password: string
}

// Xác thực form với Yup
const validationSchema = yup.object().shape({
    email: yup
        .string()
        .email('Vui lòng nhập một email hợp lệ.')
        .required('Email là bắt buộc.'),
    password: yup
        .string()
        .required('Mật khẩu là bắt buộc.')
        .min(6, 'Mật khẩu phải có ít nhất 6 ký tự.')
})

const Login = () => {
    const { login, user } = useAuth()
    console.log(user);

    const { register, handleSubmit, formState: { errors } } = useForm<LoginFormInput>({
        resolver: yupResolver(validationSchema)
    })

    const onSubmit = (data: LoginFormInput) => {
        login(data.email, data.password)
    }

    return (
        <section className="volunteer-section section-padding" id="section_4">
            <div className="container">
                <div className="row">

                    <div className="col-lg-6 col-12">
                        <h2 className="text-white mb-4">Đăng nhập</h2>

                        <form
                            className="custom-form volunteer-form mb-5 mb-lg-0"
                            onSubmit={handleSubmit(onSubmit)}
                        >
                            <div className="mb-3">
                                <input
                                    type="email"
                                    id="email"
                                    className="form-control"
                                    placeholder="Jackdoe@gmail.com"
                                    {...register('email')}
                                />
                                {errors.email && (
                                    <p className="text-danger">{errors.email.message}</p>
                                )}
                            </div>

                            <div className="mb-3">
                                <input
                                    type="password"
                                    id="password"
                                    className="form-control"
                                    placeholder="Mật khẩu"
                                    {...register('password')}
                                />
                                {errors.password && (
                                    <p className="text-danger">{errors.password.message}</p>
                                )}
                            </div>

                            <button type="submit" className="form-control btn btn-primary">
                                Đăng nhập
                            </button>
                        </form>
                    </div>

                    <div className="col-lg-6 col-12">
                        <img
                            src="images/smiling-casual-woman-dressed-volunteer-t-shirt-with-badge.jpg"
                            className="volunteer-image img-fluid"
                            alt=""
                        />

                        <div className="custom-block-body text-center">
                            <h4 className="text-white mt-lg-3 mb-lg-3">About Volunteering</h4>
                            <p className="text-white">
                                Lorem Ipsum dolor sit amet, consectetur adipsicing kengan omeg kohm tokito
                                Professional charity theme based
                            </p>
                        </div>
                    </div>

                </div>
            </div>
        </section>
    )
}

export default Login
