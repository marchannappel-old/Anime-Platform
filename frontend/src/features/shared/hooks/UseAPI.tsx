import {useEffect, useState} from "react";
import APIService from "../services/APIService";

/*
 * Generic API request hook
 * @param method 
 * @param params 
 * @returns 
 */
export default function useAPI<T>(method: string, ...params: any[]) {
  const [data, setData]           = useState([] as T);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError]         = useState("");

  const getData = async () => {
    setError("");

    try {
      setIsLoading(true);
      // @ts-ignore
      const temp: any = await APIService[method](...params);
      setData(temp);
    } catch (e: any) {
      setError(e.message);
    } finally {
      setIsLoading(false);
    }
  };

  useEffect(() => {
    getData();
  }, []);

  return { data, isLoading, error, getData };
}

/**
 * Usage array types: 
 * const api = useAPI<TypeDTO[]>('requestname');
 * useEffect(() => {
 *   setGame(api.data); 
 * }, [api.data]);
 * 
 * return(
 *      api.data.map((items, i) => (
 *          <SomeComponent key={i} prop={items}/>
 *      ))
 * )
 */

/*
 * Usage single type:
 * const api = useAPI<Type>('requestname', id);
 * useEffect(() => {
 *   setGame(api.data); 
 * }, [api.data]);
 * 
 * return(
 *      <p>{api.data.id}</p>
 * )
 */