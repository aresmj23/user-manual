# Crear prestadores

1. Hacer los scripts de sql de 
    social_reason
    company_social
    prestadores

2. Ejecucar el archivo GenerarSql para generar los sql de administrativos -> social_admin

3. Ejecucar el archivo GenerarSql para generar los sql de medicos -> social_medical

4. Ejecucar el archivo GenerarSql para generar los sql de liquidadores -> social_liquidator

5. Ejecutar los scripts de "social_reason, company_social, prestadores" en openkm

6. Ejecutar los scripts de "social_admin, social_medical, social_liquidator" en openkm

7. En openkm ejecutar CreateSocialReason.bsh y cambiar el perfil a razon social

8. Cambiar de perfil de RS0096 al perfil de RazonSocial

9. En openkm ejecutar CreatePrestadores.bsh y cambiar el perfil a prestadores

10. Cambiar de perfil de 30715332589 al perfil de Prestador

11. En openkm ejecutar UpdateAdmin y verificar que los roles esten asignados ROLE_AUDITOR_ADMINISTRATIVO

12. En openkm ejecutar UpdateLiquidador y verificar que los roles esten asignados ROLE_LIQUIDADOR

13. En openkm ejecutar UpdateMedical y verificar que los roles esten asignados ROLE_AUDITOR_MEDICO
