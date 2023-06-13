import { Box } from "./Box";
import React from "react";
import { MovieDataTypes } from "../../utils/Types";
import { RandomMovie } from "../RandomMovie/RandomMovie";

interface FeedProps {
  data: MovieDataTypes[];
}

export const Feed: React.FC<FeedProps> = ({ data }) => {
  return (
    <>
      <RandomMovie />
      <div className="flex flex-wrap container mx-auto">
        {data.map((item) => (
          <Box
            key={item.movieId}
            likes={item.numberOfLikes}
            title={item.movieTitle}
            coverLink={item.movieCover}
            movieLink={item.movieLink}
            id={item.movieId}
          />
        ))}
      </div>
    </>
  );
};
