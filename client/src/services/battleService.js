const baseURL = 'http://localhost:5000/api/battle/'

const battleService = {
    getBattle() {
        return fetch(baseURL)
            .then(res => res.json())
    }
}

export default battleService