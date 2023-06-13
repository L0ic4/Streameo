import axios, { AxiosResponse } from "axios";

type ApiResponse<T> = AxiosResponse<T>;
const BASE_URL = "http://192.168.88.88:8888";
export const apiRequest = async <T = any>(
  endpoint: string,
  method: "get" | "post" | "put" | "delete" = "get",
  data?: any
): Promise<ApiResponse<T>> => {
  const headers = {
    "Content-Type": "application/json",
    Accept: "application/json",
  };
  const url = `${BASE_URL}/${endpoint}`;
  try {
    const response = await axios({
      url,
      method,
      headers,
      data,
    });
    return response;
  } catch (error) {
    throw error;
  }
};
