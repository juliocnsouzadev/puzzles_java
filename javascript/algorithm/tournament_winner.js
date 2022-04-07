module.exports = class TournamentWinner {
    get(competitions, results) {
        const points = {};
        let leader = null;
        higherScore = 0;
        for (i = 0; i < competitions.length; i++) {
            const winner =
                results[i] === 1 ? competitions[i][0] : competitions[i][1];
            actualPoints = points[winner];
            actualPoints = !actualPoints ? 3 : actualPoints + 3;
            points[winner] = actualPoints;
            if (actualPoints > higherScore) {
                higherScore = actualPoints;
                leader = winner;
            }
        }
        return leader;
    }
};
