const baseURL = 'http://localhost:8080/'


// const postTrainers = () => {
//     return fetch(baseURL + "trainers", {
//         method: 'POST',
//         headers: { 'Content-Type': 'application/json' }
//     })
//     .then(res => res.json())
// }

const postTrainers = () => {
    // POST request using fetch with async/await
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' }
    };
    const response = fetch(baseURL + "trainers", requestOptions);
    const data = response.json();
    this.setState({ postId: data.id });
}

export default postTrainers;