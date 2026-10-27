import { useState } from "react";


export const AddTicket = () => {
    const priorityValues = ['HIGH', 'MEDIUM', 'LOW']
    const [subject, setSubject] = useState("")
    const [issue, setIssue] = useState("")
    const [priority , setPrioriy] = useState("")

    const processInput = (e) => {
        e.preventDefault();
        console.log("in the function");
        console.log(subject);
        console.log(issue);
        console.log(priority);

    }

    return (
        <div className="card">
            <div className="card-header">
                Ticket Creation Form
            </div>
            <div className="card-body">
                <form onSubmit={(e) => processInput(e)}>
                    <div className="mb-4">
                        <label>Enter Subject: </label>
                        <input type="text" className="form-control" required="required" 
                        onChange={(e)=>setSubject(e.target.value)}/>

                    </div>
                    <div className="mb-4">
                        <label>Enter Issue: </label>
                        <textarea className="form-control" required="required" 
                        onChange={(e)=>setIssue(e.target.value)}/>

                    </div>
                    <div className="mb-4">
                        <label>Enter Priority: </label>
                        <select className="form-control" required="required" 
                        onChange={(e)=>setPrioriy(e.target.value)}>
                            <option value="" >----select priotity-----</option>
                            {
                                priorityValues.map((val, index) => (
                                    <option key={index}>{val}</option>
                                ))

                            }
                        </select>

                    </div>
                    <input type="submit" className="btn btn-info" value="Process Input"></input>
                </form>
            </div>
        </div>
    )
}

