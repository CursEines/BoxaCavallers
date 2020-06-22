from random import seed
from random import randrange, choice
from llocOnPicar import LlocOnPicar
from ILluitador import ILluitador


class LluitadorMatxacaSaurio(ILluitador):

    def __init__(self, nom='MatxacaSaurio'):
        self._nom = nom
        self._copsPossibles = [LlocOnPicar.CAP, LlocOnPicar.PANXA]
        self.nCop = 0

    def get_nom(self) -> str:
        """retorna el nom del lluitador."""
        return self._nom

    def Protegeix(self) -> list:
        """Llista de llocs on es protegeix"""
        llocs = self._copsPossibles.copy()
        llocs.pop(randrange(len(llocs)))
        return llocs

    def Pica(self):
        """Determina on pica el lluitador"""
        pica = self._copsPossibles[self.nCop]
        self.nCop = (self.nCop+1) % 2
        return pica

    def get_Forca(self) -> int:
        """Determina la força del cop"""
        return 1
