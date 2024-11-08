import React from 'react'
import Topbar from '../Component/Topbar/Topbar'
import Navbar from '../Component/Navbar/Navbar'
import { Outlet } from 'react-router-dom'

const Layout = () => {
  return (
    <div>
      <Topbar />
      <Navbar />
      <main>
        <Outlet />
      </main>
    </div>
  )
}

export default Layout
