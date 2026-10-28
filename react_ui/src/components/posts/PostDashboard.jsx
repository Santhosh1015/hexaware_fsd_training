import axios from "axios";
import { useEffect, useState } from "react";

function PostDashboard() {

    const postsApiUrl = 'https://jsonplaceholder.typicode.com/posts'
    const [posts, setPosts] = useState([])
    const [userId, setUserId] = useState(0)
    const [title, setTitle] = useState("")
    const [body, setBody] = useState("")

    useEffect(() => {

        const getUserPosts = async () => {
            try {
                const response = await axios.get(postsApiUrl)
                setPosts(response.data)
            } catch (err) {

            }


        }
        getUserPosts()

    }, [])

    const addPost = async () => {
        let postObj = {
            'title': title,
            'userId': userId,
            'body': body
        }
        const response = await axios.post(postsApiUrl, postObj)
       
        setPosts([response.data, ...posts])
    }

    return (
        <div>
            <div>
                <button className="btn btn-outline-info" data-bs-toggle="modal" data-bs-target="#addPostModal"> +AddPost</button>
            </div>
            {
                posts.map((p, index) => (
                    <div className="card mt-4 mb-4" key={index}>
                        <div className="card-header d-flex ">
                            <h6>Post ID: {p.id}</h6>
                            &nbsp;&nbsp; &nbsp;&nbsp;
                            <h6>Post By User ID: {p.userId}</h6>
                        </div>
                        <div className="card-body ">
                            <div className="card-title">
                                <h4>{p.title}</h4>
                            </div>
                            <div>
                                {p.body}
                            </div>
                        </div>
                    </div>

                ))

            }
            <div className="modal fade" id="addPostModal" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h5 className="modal-title" id="exampleModalLabel">Add Post</h5>


                            <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div className="modal-body">
                            <div>
                                <label>Title</label>
                                <input type="text" value={title} onChange={(e) => setTitle(e.target.value)} className="form-control" required="required" />
                            </div>
                            <div>
                                <label>User Id</label>
                                <input type="text" value={userId} onChange={(e) => setUserId(e.target.value)} className="form-control" required="required" />
                            </div>
                            <div>
                                <label>Body</label>
                                <input type="text" value={body} onChange={(e) => setBody(e.target.value)} className="form-control" required="required" />
                            </div>
                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" className="btn btn-primary" onClick={() => addPost()} data-bs-dismiss="modal" >Add</button>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
export default PostDashboard