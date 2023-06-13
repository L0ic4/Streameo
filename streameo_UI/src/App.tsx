import { BrowserRouter, Routes, Route } from "react-router-dom";
import { Header } from "./Components/Header/Header";
import { Footer } from "./Components/Footer/Footer";
import { MovieDetails } from "./Components/MovieDetails/MovieDetails";

import { NavBar } from "./Components/Navbar/NavBar";
import "./App.css";
function App() {
  return (
    <BrowserRouter>
      <Header />
      <Routes>
        <Route path="/" element={<NavBar />} />
        <Route path="/movie/:id" element={<MovieDetails />} />
      </Routes>
      <Footer />
    </BrowserRouter>
  );
}

export default App;
