class Solution:
    def validUtf8(self, data: List[int]) -> bool:
        five = 0b11111000
        four = 0b11110000
        three = 0b11100000
        two = 0b11000000
        one = 0b10000000
        byte = 0b11111111
        ind = 0
        while ind < len(data):
            num = data[ind] & byte
            
            if five & num == four:
                ind += 1
                if ind >= len(data) or data[ind] & byte & two != one:
                    return False
                ind += 1
                if ind >= len(data) or data[ind] & byte & two != one:
                    return False
                ind += 1
                if ind >= len(data) or data[ind] & byte & two != one:
                    return False
                ind += 1
            elif four & num == three:
                ind += 1
                if ind >= len(data) or data[ind] & byte & two != one:
                    return False
                ind += 1
                if ind >= len(data) or data[ind] & byte & two != one:
                    return False
                ind += 1
            elif three & num == two:
                ind += 1
                if ind >= len(data) or data[ind] & byte & two != one:
                    return False
                ind += 1
            else:
                if num & one == one:
                    return False
                ind += 1
        return True