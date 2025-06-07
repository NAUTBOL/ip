import React from 'react';
import { Heart, LayoutGrid } from 'lucide-react';

const Header: React.FC = () => {
  return (
    <header className="fixed top-0 left-0 right-0 z-50 bg-vercel-black/80 backdrop-blur-md border-b border-vercel-border">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="flex justify-between items-center h-16">
          <div className="flex items-center space-x-2">
            <div className="w-8 h-8 bg-gradient-to-br from-blue-500 to-purple-600 rounded-lg flex items-center justify-center">
              <span className="text-white font-bold text-sm">IP</span>
            </div>
            <span className="text-vercel-text font-montserrat font-semibold text-lg">
              IP Address Display
            </span>
          </div>
          
          <div className="flex items-center space-x-4">
            <a
              href="https://www.paypal.com/paypalme/NAUTBOL"
              target="_blank"
              rel="noopener noreferrer"
              className="inline-flex items-center px-4 py-2 bg-gradient-to-r from-pink-500 to-red-500 hover:from-pink-600 hover:to-red-600 text-white font-montserrat font-medium rounded-lg transition-all duration-200 transform hover:scale-105 focus:outline-none focus:ring-2 focus:ring-pink-500 focus:ring-offset-2 focus:ring-offset-vercel-black"
              aria-label="Donate via PayPal"
            >
              <Heart className="w-4 h-4 mr-2" />
              <span className="hidden sm:inline">Donate</span>
            </a>
            
            <a
              href="https://www.kuantyk.com/"
              target="_blank"
              rel="noopener noreferrer"
              className="inline-flex items-center px-4 py-2 bg-vercel-light-gray hover:bg-vercel-border text-vercel-text font-montserrat font-medium rounded-lg transition-all duration-200 transform hover:scale-105 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2 focus:ring-offset-vercel-black"
              aria-label="Visit More Apps"
            >
              <LayoutGrid className="w-4 h-4 mr-2" />
              <span className="hidden sm:inline">More Apps</span>
            </a>
          </div>
        </div>
      </div>
    </header>
  );
};

export default Header;