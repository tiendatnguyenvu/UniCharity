import React from 'react'
import FormReport from './ReportForm'
import { CreateReport } from '../../../Models/Report'

const CreateReport = () => {

    const handleCreate =(data:CreateReport) =>{
        console.log("create: ", data)
        
    }
    
  return (
    <div>
      <FormReport handle={handleCreate}/>
    </div>
  )
}

export default CreateReport
