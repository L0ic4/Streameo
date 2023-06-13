import React, { useEffect, useState } from "react";
import { Loading } from "../Loading/Loading";
import { apiRequest } from "../../utils/fetchFromAPI";
import { MovieDataTypes } from "../../utils/Types";

export const MovieDetails: React.FC = () => {
  const [loading, setLoading] = useState(false);
  const [data, setData] = useState<MovieDataTypes>({
    movieCover: "",
    movieDescription: "",
    movieId: 0,
    movieLink: "",
    movieTitle: "",
    numberOfComments: 0,
    numberOfDisLikes: 0,
    numberOfLikes: 0,
  });
  const videoId = window.location.pathname.split("/movie/")[1];
  useEffect(() => {
    setLoading(true);
    const fetchMovieData = async () => {
      try {
        const response = await apiRequest(`movie/${videoId}`);
        setData(response.data);
        setLoading(false);
      } catch (error) {
        console.error(error);
      }
    };
    fetchMovieData();
  }, [videoId]);
  return (
    <>
      {loading ? (
        <Loading />
      ) : (
        <div className="flex flex-col gap-6 container mx-auto">
          <video controls src={data.movieLink}></video>
          <div className="flex flex-nowrap flex-row gap-6">
            <div className="like">
              <span className="likes-count">{data.numberOfLikes}</span>
              <span className="likes-text">Likes</span>
            </div>
            <div className="dislike">
              <span className="likes-count">{data.numberOfDisLikes}</span>
              <span className="likes-text">Dislikes</span>
            </div>
          </div>
          <div className="grid grid-cols-4 gap-3 grid-flow-row grid-">
            <div className="row-start-1 row-end-4 grid gap-2">
              <img className="h-60" src={data.movieCover} alt="" />
              <h2 className="video-title">{data.movieTitle}</h2>
            </div>
            <p className="col-start-2 col-end-4">{data.movieDescription}</p>
          </div>
        </div>
      )}
    </>
  );
};
