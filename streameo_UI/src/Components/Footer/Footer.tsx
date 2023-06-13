import React from "react";

export const Footer: React.FC = () => {
  return (
    <footer className="bottom-0 p-8 mt-6 bg-slate-500 w-full justify-center">
      <div className="grid grid-cols-2 font-bold items-center">
        <p className="lf"></p>
        <p className="rf">
          Design by <a href="http://chocotemplates.com/">ChocoTemplates.com</a>
        </p>
      </div>
    </footer>
  );
};
