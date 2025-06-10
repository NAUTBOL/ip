import React, { useState, useEffect } from 'react';
import { Globe, Wifi, MapPin } from 'lucide-react';
import { API_URL } from '../core/config';

interface IPData {
  ip: string;
  location?: string;
  isp?: string;
}

const Hero: React.FC = () => {
  const [ipData, setIpData] = useState<IPData | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  const fetchIPData = async (): Promise<IPData> => {
    const url = API_URL + "ip/info";
    const response = await fetch(url);
    if (!response.ok) {
      throw new Error(`${response.status}`);
    }
    const data = await response.json();
    return data as IPData;
  };

  useEffect(() => {
    const getIPData = async () => {
      try {
        setLoading(true);
        setError(null);
        const data = await fetchIPData();
        setIpData(data);
      } catch (err) {
        setError('Failed to fetch IP data. Please try again.');
      } finally {
        setLoading(false);
      }
    };

    getIPData();
  }, []);

  const handleRefresh = () => {
    setIpData(null);
    setLoading(true);
    setError(null);

    const getIPData = async () => {
      try {
        const data = await fetchIPData();
        setIpData(data);
      } catch (err) {
        setError('Failed to fetch IP data. Please try again.');
      } finally {
        setLoading(false);
      }
    };

    getIPData();
  };

  return (
    <section className="min-h-screen flex items-center justify-center px-4 sm:px-6 lg:px-8 pt-16 pb-8">
      <div className="max-w-4xl mx-auto text-center">
        <div className="animate-slide-up">
          <h1 className="text-4xl sm:text-5xl lg:text-6xl font-montserrat font-bold text-vercel-text mb-6 mt-6">
            Discover Your
            <span className="block bg-gradient-to-r from-blue-400 via-purple-500 to-pink-500 bg-clip-text text-transparent">
              IP Address
            </span>
          </h1>

          <p className="text-lg sm:text-xl text-vercel-text-secondary font-montserrat mb-12 max-w-2xl mx-auto">
            Get real-time information about your public IP address.
          </p>
        </div>

        <div className="bg-vercel-gray/50 backdrop-blur-sm border border-vercel-border rounded-2xl p-8 sm:p-12 shadow-2xl animate-fade-in">
          {loading ? (
            <div className="flex flex-col items-center justify-center py-12">
              <div className="animate-spin rounded-full h-16 w-16 border-4 border-blue-500 border-t-transparent mb-6"></div>
              <p className="text-vercel-text-secondary font-montserrat">
                Fetching your IP address...
              </p>
            </div>
          ) : error ? (
            <div className="flex flex-col items-center justify-center py-12">
              <div className="w-16 h-16 bg-red-500/20 rounded-full flex items-center justify-center mb-6">
                <Wifi className="w-8 h-8 text-red-500" />
              </div>
              <p className="text-red-400 font-montserrat mb-6">{error}</p>
              <button
                onClick={handleRefresh}
                className="px-6 py-3 bg-blue-600 hover:bg-blue-700 text-white font-montserrat font-medium rounded-lg transition-colors duration-200 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2 focus:ring-offset-vercel-gray"
              >
                Try Again
              </button>
            </div>
          ) : ipData ? (
            <div className="animate-bounce-soft">
              <div className="mb-8">
                <div className="inline-flex items-center justify-center w-20 h-20 bg-gradient-to-br from-blue-500 to-purple-600 rounded-full mb-6 animate-pulse-glow">
                  <Globe className="w-10 h-10 text-white" />
                </div>

                <div className="text-center mb-8">
                  <p className="text-vercel-text-secondary font-montserrat text-sm uppercase tracking-wider mb-2">
                    Your IP Address
                  </p>
                  <h2 className="text-4xl sm:text-5xl font-montserrat font-bold text-vercel-text font-mono tracking-wider">
                    {ipData.ip}
                  </h2>
                </div>

                <div className="grid grid-cols-1 sm:grid-cols-2 gap-6 max-w-md mx-auto">
                  {ipData.location && (
                    <div className="flex items-center justify-center space-x-3 bg-vercel-light-gray/50 rounded-lg p-4">
                      <MapPin className="w-5 h-5 text-blue-400" />
                      <div className="text-left">
                        <p className="text-xs text-vercel-text-secondary font-montserrat uppercase tracking-wide">
                          Location
                        </p>
                        <p className="text-vercel-text font-montserrat font-medium">
                          {ipData.location}
                        </p>
                      </div>
                    </div>
                  )}

                  {ipData.isp && (
                    <div className="flex items-center justify-center space-x-3 bg-vercel-light-gray/50 rounded-lg p-4">
                      <Wifi className="w-5 h-5 text-green-400" />
                      <div className="text-left">
                        <p className="text-xs text-vercel-text-secondary font-montserrat uppercase tracking-wide">
                          Provider
                        </p>
                        <p className="text-vercel-text font-montserrat font-medium">
                          {ipData.isp}
                        </p>
                      </div>
                    </div>
                  )}
                </div>
              </div>

              <button
                onClick={handleRefresh}
                className="px-8 py-3 bg-gradient-to-r from-blue-600 to-purple-600 hover:from-blue-700 hover:to-purple-700 text-white font-montserrat font-medium rounded-lg transition-all duration-200 transform hover:scale-105 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2 focus:ring-offset-vercel-gray"
              >
                Refresh IP
              </button>
            </div>
          ) : null}
        </div>
      </div>
    </section>
  );
};

export default Hero;