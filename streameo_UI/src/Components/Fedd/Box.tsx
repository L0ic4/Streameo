import React from "react";
import { Link } from "react-router-dom";

interface BoxProps {
  id: number;
  likes: number;
  title: string;
  coverLink: string;
  movieLink: string;
}

export const Box: React.FC<BoxProps> = ({ id, coverLink, likes, title }) => {
  return (
    <div className="box-content shadow-2xl h-42 w-32 p-4 m-4 dark:bg-gray-700 rounded-lg">
      <div className="movie">
        <div className="relative">
          <Link to={"/movie/" + id}>
            <img className="rounded-lg" src={coverLink} alt="" />
          </Link>
          <>{likes}</>
        </div>
        <span className="name">{title}</span>
        <div className="rating">
          <p>RATING</p>
          <div className="stars">
            <div className="stars-in"></div>
          </div>
        </div>
      </div>
    </div>
  );
};
