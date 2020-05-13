import { useEffect, useState } from "react";
import axios, { AxiosRequestConfig } from "axios";

const useFetch = (url: string, options: AxiosRequestConfig) => {
  const [response, setResponse] = useState<any>(null);
  const [error, setError] = useState<any>(null);
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      setIsLoading(true);
      try {
        const res = await (await axios(url, options)).data;
        if (!res.success) {
          throw new Error("fetching has failed");
        }
        setIsLoading(false);
        setResponse(res.response);
      } catch (error) {
        setError(error);
      }
    };
    fetchData();
  }, []);

  return { response, error, isLoading };
};

export default useFetch;
