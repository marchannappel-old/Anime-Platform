import axios from "axios";
/*
    Types import
    Enpoint import
*/

/**
 * Generic GET request
 * @param path 
 * @returns 
 */
async function getRequest(path: string) {
    return axios.get(path);
}

/**
 * Generic POST Request
 * @param path 
 */
async function postRequest(path: string) {
    
}

/**
 * Generic PUT/PATCH request
 * @param path 
 */
async function editRequest(path: string) {
    
}

/**
 * Generic DELETE request
 * @param path 
 */
async function deleteRequest(path: string) {
    
}

const APIService = {
    /*
     * Example list all request 
     * @returns 
     */
    list: async() => {
        return await getRequest(`${endpoint}`).then(x => x.data as Type[]);
    },

    /*
     * Example get by id request 
     * @param id 
     * @returns 
     */
    read: async(id: number) => {
        return await getRequest(`${endpoint}/${id}`).then(x => x.data as Type);
    }
}

export default APIService;