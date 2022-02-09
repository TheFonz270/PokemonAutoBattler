const baseURL = 'http://localhost:8080/'


// const postTrainers = () => {
//     return fetch(baseURL + "trainers", {
//         method: 'POST',
//         headers: { 'Content-Type': 'application/json' }
//     })
//     .then(res => res.json())
// }

export const RandomisePokemonRequest = (id) => {
    const requestOptions = {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' }
    };
    const response = fetch(baseURL + `pokemons/${id}`, requestOptions)
    .then(response => response.json())
    .then(data => {console.log(data)})
}


export const RandomiseMoveRequest = (id) => {
    const requestOptions = {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' }
    };
    const response = fetch(baseURL + `pokemons/${id}/move`, requestOptions)
    .then(response => response.json())
    .then(data => {console.log(data)})
}



export const LevelUpRequest = (id) => {
    const requestOptions = {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' }
    };
    const response = fetch(baseURL + `pokemons/${id}/levelup`, requestOptions)
    .then(response => response.json())
    .then(data => {console.log(data)})
}
