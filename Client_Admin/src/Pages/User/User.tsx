import React, { useEffect, useState } from 'react'
import { UserGet } from '../../Models/User'
import { PageObject } from '../../Models/Paginate'
import { useNavigate } from 'react-router'
import Paginate from '../../Components/Paginate/Paginate'
import Table from '../../Components/Table/Table'
import { UserGetAPI } from '../../Service/userService'


const User = () => {
    const [users, setUsers] = useState<UserGet[]>([])
    const [pageObject, setPageObject] = useState<PageObject>()

    const navigate = useNavigate()

    useEffect(() => {
        UserGetAPI(0, 4)
            .then(res => {
                if (res?.data) {
                    setUsers(res.data.result.items)
                    setPageObject(res.data.result.page)
                    console.log(res?.data);
                }
            })
    }, [])

    const configs = [
        {
            label: "#",
            render: (userGet: UserGet, index: number) => index + 1,
        },
        {
            label: "userGet's Name",
            render: (userGet: UserGet) => userGet.name,
        },
    ]

    const handlePageChange = () => {}

    return (
        <div className='container-fluid pt-4 px-4' >

            <h1>Category Management</h1>
            <div className="col-12">
                <div className="rounded-2 border shadow custom-container h-100 " style={{ padding: "18px 58px" }}>
                    <div style={{ height: "100px" }} className='d-flex align-items-center' >
                        <h6 className="mb-4">Attribute List</h6>
                        <button className='btn btn-primary ms-auto'
                            onClick={() => { navigate("/attribute/create") }}
                        >
                            Create a new attribute

                        </button>
                    </div>
                    <div className="table-responsive"></div>
                    {users && pageObject
                        ? <>
                            <Table data={users} configs={configs} />
                            <Paginate
                                onPageChange={handlePageChange}
                                page={pageObject!}

                            />
                        </>
                        : <h1>Loading</h1>
                    }
                </div>
            </div>
        </div>
    )
}

export default User
