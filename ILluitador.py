from random import sample, choice

from llocOnPicar import Atac


class ILluitador:
    def get_nom(self) -> str:
        return self._nom

    def Protegeix(self) -> list:
        return sample(self._copsPossibles, 3)

    def Pica(self):
        pica = choice(self._copsPossibles)
        return Atac.NORMAL, pica
