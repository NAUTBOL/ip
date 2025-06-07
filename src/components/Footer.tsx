import React from 'react';
import { Twitter, Linkedin, Github } from 'lucide-react';

const Footer: React.FC = () => {
  const socialLinks = [
    {
      name: 'Twitter',
      url: 'https://x.com/NAUTBOL',
      icon: Twitter,
      color: 'hover:text-blue-400',
      bgColor: 'hover:bg-blue-400/10',
    },
    {
      name: 'LinkedIn',
      url: 'https://www.linkedin.com/in/leandrotorressilva/',
      icon: Linkedin,
      color: 'hover:text-blue-600',
      bgColor: 'hover:bg-blue-600/10',
    },
    {
      name: 'GitHub',
      url: 'https://github.com/NAUTBOL/',
      icon: Github,
      color: 'hover:text-gray-300',
      bgColor: 'hover:bg-gray-300/10',
    },
  ];

  return (
    <footer className="bg-vercel-gray/30 border-t border-vercel-border">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-12">
        <div className="text-center">
          <div className="flex justify-center space-x-6 mb-8">
            {socialLinks.map((social) => {
              const IconComponent = social.icon;
              return (
                <a
                  key={social.name}
                  href={social.url}
                  target="_blank"
                  rel="noopener noreferrer"
                  className={`group flex items-center justify-center w-14 h-14 bg-vercel-light-gray/50 rounded-full transition-all duration-300 transform hover:scale-110 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2 focus:ring-offset-vercel-black ${social.bgColor}`}
                  aria-label={`Visit ${social.name} profile`}
                >
                  <IconComponent 
                    className={`w-6 h-6 text-vercel-text-secondary transition-colors duration-300 group-hover:scale-110 ${social.color}`} 
                  />
                </a>
              );
            })}
          </div>
          
          <div className="text-vercel-text-secondary font-montserrat text-sm">
            <p className="mb-2">
              Built with React, TypeScript, and Tailwind CSS
            </p>
          </div>
        </div>
      </div>
    </footer>
  );
};

export default Footer;