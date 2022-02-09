const baseURL = 'http://localhost:8080/'


// const postTrainers = () => {
//     return fetch(baseURL + "trainers", {
//         method: 'POST',
//         headers: { 'Content-Type': 'application/json' }
//     })
//     .then(res => res.json())
// }

export const randomisePokemonRequest = (id) => {
    const requestOptions = {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' }
    };
    return fetch(baseURL + `pokemons/${id}`, requestOptions)
    .then(response => response.json())
    }    



export const randomiseMoveRequest = (id) => {
    const requestOptions = {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' }
    };
    return fetch(baseURL + `pokemons/${id}/move`, requestOptions)
    .then(response => response.json())
}



export const levelUpRequest = (id) => {
    const requestOptions = {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' }
    };
    return fetch(baseURL + `pokemons/${id}/levelup`, requestOptions)
    .then(response => response.json())
}

export const teamSubmition = (id, selectedTeam) => {
    const requestOptions = {
        method: 'PUT',
        body: selectedTeam,
        headers: { 'Content-Type': 'application/json' }
    };
    return fetch(baseURL + `trainers/${id}`, requestOptions)
    .then(response => response.json())
}
