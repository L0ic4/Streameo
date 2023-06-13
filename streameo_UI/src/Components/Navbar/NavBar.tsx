import React, { useEffect, useState } from "react";
import { apiRequest } from "../../utils/fetchFromAPI";
import { Feed } from "../Fedd/Feed";
import { SearchBar } from "./SearchBar ";
import { Loading } from "../Loading/Loading";
import { MovieDataTypes } from "../../utils/Types";

export const NavBar: React.FC = () => {
  const [movieData, setMovieData] = useState<MovieDataTypes[]>([]);

  const [searchTerm, setSearchTerm] = useState<string>("");

  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);
    const fetchMovieData = async () => {
      try {
        const response = await apiRequest<MovieDataTypes[]>(
          searchTerm ? `movies/${searchTerm}` : "movies"
        );
        setMovieData(response.data);
        setLoading(false);
      } catch (error) {
        console.error(error);
      }
    };
    fetchMovieData();
  }, [searchTerm]);

  const handleSearchInputChange = (
    event: React.ChangeEvent<HTMLInputElement>
  ) => {
    setSearchTerm(event.target.value);
  };

  return (
    <>
      {loading ? <Loading /> : <Feed data={movieData} />}
      <SearchBar
        onSearchInputChange={handleSearchInputChange}
        searchTerm={searchTerm}
      />
    </>
  );
};
