import { Link } from "react-router-dom";
import React from "react";
import logo from "../../images/logo.gif";

export const Header: React.FC = () => {
  return (
    <nav className="flex m-8 p-2 bg-slate-500 rounded-lg">
      <h1 id="logo" className="flex-1">
        <Link to="/">
          <img src={logo} alt="" />
        </Link>
      </h1>
      <div id="navigation" className="flex-1 ">
        <ul className="grid grid-cols-3 font-bold">
          <li>
            <Link to="/"></Link>
          </li>
          <li>
            <Link to="/">NEWS</Link>
          </li>
          <li>
            <Link to="/">COMING SOON</Link>
          </li>
        </ul>
      </div>
    </nav>
  );
};
