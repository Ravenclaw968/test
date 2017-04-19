
% This script will calculate the efficiency of DMUs with inputs (X)
% and outputs (Y).

%Outputs
Y = [71.625, 71.025, 71.275, 71.225, 71.675, 71.825, 71.675, 71.775, ...
     71.775, 71.575, 71.525, 71.575, 71.525, 71.675, 71.725, 71.625, ...
     71.475, 71.475, 71.825, 71.725, 71.325, 71.375, 71.975, 72.025, ...
     71.875, 72.075, 72.125, 71.325, 71.025, 71.425, 72.075, 70.875, ...
     71.625, 71.425, 71.725, 72.125, 72.025, 71.775, 71.425, 71.525, ...
     71.175, 71.575];

% Inputs
X = [61.418, 62.478, 62.805, 61.369, 60.744, 63.714, 62.779, 61.745, ...
     62.560, 63.457, 61.314, 61.730, 61.610, 62.160, 60.362, 61.934, ...
     62.192, 61.403, 60.173, 62.562, 60.710, 60.502, 63.648, 63.870, ...
     63.644, 63.763, 61.192, 63.545, 62.181, 62.746, 62.019, 61.572, ...
     62.603, 61.522, 59.567, 64.804, 61.854, 61.593, 63.570, 61.658, ...
     62.529, 60.056];

[mIn,  nIn]  = size(X);
[mOut, nOut] = size(Y);

m = mIn+mOut+2;
n = nIn+2;

for ih = 1:nIn
   b = zeros(m,1);
   b(mIn+mOut+1:mIn+mOut+2) = 1;
   c = [zeros(nIn+1,1); 1; zeros(mIn+mOut,1)];
   A = zeros(m, n+mIn+mOut);
   A(1:m,1:n) = [-Y, Y(:,ih), zeros(mOut,1); ...
                  X, zeros(mIn,1), -X(:,ih); ...
                  ones(1,nIn), 0, 0; ....
                  zeros(1,nIn), 1, 0];
   lowBnds = zeros(n+mIn+mOut,1);
   upBnds = inf*ones(n+mIn+mOut,1);
   for i=1:m
      if i <= mIn+mOut
         ConsType(i) = 'U';
      else
         ConsType(i) = 'S';
      end
   end
   [optWeights, effScore] = glpk(c,A,b,lowBnds,upBnds,ConsType);
   E(ih) = effScore;
end

bar(E)
