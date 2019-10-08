class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if newColor == image[sr][sc]:
            return image
        self.dfs(image, sr, sc, newColor, image[sr][sc])
        return image
    
    def dfs(self, image, sr, sc, newColor, oriColor):    
        if 0 > sr or sr >= len(image) or 0 > sc or sc >= len(image[0]):
            return
        if image[sr][sc] == oriColor:
            image[sr][sc] = newColor
            self.dfs(image, sr+1, sc, newColor, oriColor)
            self.dfs(image, sr-1, sc, newColor, oriColor)
            self.dfs(image, sr, sc+1, newColor, oriColor)
            self.dfs(image, sr, sc-1, newColor, oriColor)
        